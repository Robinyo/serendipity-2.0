import { Component, OnInit } from '@angular/core';

import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

import { AuthService } from 'auth-lib';
import { DialogService, SnackBarComponent } from 'serendipity-components-lib';
import { LoggerService } from 'utils-lib';

import { ProcessModel } from '../../../models/process-list.model';
import { ProcessesService } from '../../../services/processes/processes.service';

@Component({
  selector: 'flow-start-process-dialog',
  template: `

    <h2 mat-dialog-title>Start a process</h2>

    <mat-dialog-content class="mat-typography">

      <flow-process-list (selectEvent)="onSelectEvent($event)"> </flow-process-list>

    </mat-dialog-content>

    <mat-dialog-actions align="end">

      <button mat-raised-button
              cdkFocusInitial
              #cancelBtn
              (keydown.arrowright)="startBtn.focus()"
              (click)="onCancel()">
        {{ cancelButton }}
      </button>

      <button mat-raised-button
              color="accent"
              #startBtn
              [disabled]="isDisabled()"
              (keydown.arrowleft)="cancelBtn.focus()"
              (click)="onStart()">
        {{ startButton }}
      </button>

    </mat-dialog-actions>

  `,
})
export class StartProcessDialogComponent implements OnInit {

  public message!: string;
  public title!: string;
  public cancelButton = 'CANCEL';
  public startButton = 'START';

  private currentUser: any;
  private disabled = false;
  private selectedItem!: ProcessModel;

  constructor(private authService: AuthService,
              private dialogRef: MatDialogRef<StartProcessDialogComponent>,
              private dialogService: DialogService,
              private processesService: ProcessesService,
              private snackBar: MatSnackBar,
              private logger: LoggerService) {}

  public ngOnInit() {

    this.logger.info('StartProcessDialogComponent: ngOnInit()');

    this.currentUser = this.authService.getCurrentUser();

    this.logger.info('currentUser: ' + JSON.stringify(this.currentUser, null, 2));
  }

  public onSelectEvent(event: ProcessModel) {

    this.logger.info('StartProcessDialogComponent: onSelectEvent()');

    this.selectedItem = event;

    this.logger.info('selectedItem: ' + JSON.stringify(this.selectedItem, null, 2));

  }

  //
  // Action bar events
  //

  public onCancel(): void {

    this.dialogRef.close(false);
  }

  public onStart(): void {

    this.logger.info('StartProcessDialogComponent: onStart()');

    // This may take a while ...

    this.disabled = true;

    const options = { year: 'numeric', month: 'long', day: 'numeric' };
     // @ts-ignore
    const today = new Date().toLocaleString('en-GB', options);

    this.logger.info('today: ' + today);

    const processModel = {
      name : this.selectedItem.name + ' - ' + today,
      processDefinitionId : this.selectedItem.id,
      variables : [
        {
          name: 'initiator',
          type : 'string',
          value: this.currentUser.username,
          scope : 'local'
        }
      ]
    };

    /*

      variables : [
        {
          name: 'initiator',
          type : 'string',
          value: 'flowable',
          scope : 'local'
        }
      ]

    */

    this.logger.info('processModel: ' + JSON.stringify(processModel, null, 2));

    this.processesService.startProcess(processModel).then((responce) => {

      this.openSnackBar('Process started');

      // this.disabled = false;

      /*

      const processAction = {
        // assignee: 'flowable',
        // assignment: 'involved'
        userId : 'flowable',
        type : 'participant'
      };

      this.logger.info('processAction: ' + JSON.stringify(processAction, null, 2));

      this.processesService.updateProcess(responce.id, processAction);

      */

      this.dialogRef.close(true);

    }).catch(error => {

      // let message = error.message;
      let message = error;

      if (error.details) {
        message = error.details.message;
      }

      this.dialogService.openAlert({
        title: 'Alert',
        message: message,
        closeButton: 'CLOSE'
      });

      this.disabled = false;

    });

  }

  //
  // Validation
  //

  public isDisabled(): boolean {
    return this.disabled;
  }

  //
  // Misc
  //

  private openSnackBar(message: string) {

    this.snackBar.openFromComponent(SnackBarComponent, {
      data: {
        message: message
      },
      duration: 500,
      panelClass: 'snack-bar'
    });

  }

}

/*

      startUserId : 'flowable',

        {
          'name': 'startUserId',
          'type' : 'string',
          'value': 'flowable',
          'scope' : 'local'
        }

      'startedBy' : {
        'email' : 'admin@serendipity.org.au',
        'firstName' : 'Flowable',
        'fullName' : 'Flowable Admin',
        'groups': [],
        'id' : 'flowable',
        'lastName' : 'Admin',
        'privileges': [],
        'tenantId' : null
      },

*/
