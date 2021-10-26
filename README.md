<p align="center">
  <img src="./serendipity-logo.svg" alt="Serendipity" width="400"/>
</p>

<h1 align="center">Serendipity 2.0</h1>

<p align="center">
  <b>Serendipity is an open-source Customer Engagement Platform.</b></br>
  <b>You can use it to transform your organisation by connecting your customers, products, people and operations.</b></br>
</p>

![divider](./divider.png)

## ❯ Components

- **Progressive Web App (PWA)**
- **Backend for Frontend (BFF)**
- **Identity Server (Keycloak)**

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/context-diagram.png">
</p>

![divider](./divider.png)

## ❯ Features

- **Spring Security 5 OAuth 2.0 Login**

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/sequence-diagram.png">
</p>

![divider](./divider.png)

## ❯ Quick Start

Clone the project by running the following command:

```
git clone https://github.com/Robinyo/serendipity-2.0
``` 

### Kubernetes

To serve the applications (from the /backend directory):

```
# Create a dedicated namespace for our deployments
kubectl create ns serendipity

# Deploy the Serendipty Identity Service
kubectl apply -n serendipity -f serendipity-identity-server.yaml

# Deploy the Serendipty PWA and BFF
kubectl apply -n serendipity -f serendipity.yaml
```

The containers may take a minute or two to startup.

Navigate to: http://127.0.0.1:30001

### Kubernetes Dashboard

Follow these [steps](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/) to deploy the 
Kubernetes Dashboard:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/kubernetes-dashboard.png">
</p>

### Docker

To serve the applications (from the /backend directory):

```
docker-compose up -d
```

The containers may take a minute or two to startup.

Navigate to: http://127.0.0.1:30001

![divider](./divider.png)

## ❯ Docker Hub

See: https://hub.docker.com/u/robinyo

![divider](./divider.png)

## ❯ Links

[Documentation, demos, and guides](./docs/README.md)

![divider](./divider.png)

## ❯ Screen Shots

Welcome Page:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/welcome-page.png">
</p>

### Navigation

Navigation Bar:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/navigation-bar.png">
</p>

Command Bar:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/command-bar.png">
</p>

Sidenav:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/sidenav.png">
</p>

### Customer Engagement

Contacts:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/contacts.png">
</p>

Contact:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/contact.png">
</p>

Accounts:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/accounts.png">
</p>

### Workflow (BPMN), Decision Management (DMN) and Case Management (CMMN)

New Work Item:

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/new-work-item.png">
</p>

### Interactive Maps

<p align="center">
  <img src="https://github.com/Robinyo/serendipity-2.0/blob/main/docs/screen-shots/electoral-division.png">
</p>
