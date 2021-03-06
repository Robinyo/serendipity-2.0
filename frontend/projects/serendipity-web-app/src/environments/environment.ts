// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

import { Environment } from './models';

export const environment: Environment = {

  production: false,

  serverScheme: 'http',
  serverHost: '127.0.0.1',
  serverPort: '30001',

  partyServicePort: '30101',
  workServicePort: '30102',

  defaultLanguage: 'en-gb', // 'en-gb', 'de-ch'

  isDebugMode: true,

  version: '0.0.1-beta.3',

  sentryDsn: ''

};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
