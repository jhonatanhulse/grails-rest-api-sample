# Grails REST API Sample

This project is a simple integration between Grails and Slack Incoming Webhooks. With this project you will be able to create a message through a REST API and this message will be sent to a Slack channel.

## Motivation

This project has the intent of showing a bit of my coding skills and knowledge of Grails Framework.

## Practices

**Conventional Commits**

Conventional Commits is a specification that provides a set of rules for creating good commits. This specification allow developers to create tools based on these rules (e.g. automatic version generation based on commit types). More details can be found at https://www.conventionalcommits.org.

**SOLID**

I implemented this project with the SOLID principles in mind. Looking at the code you will find examples of each principle.

**TDD**

I also created some tests for the most important parts of this project.

## Requirements

This project is currently using Grails v3.3.10, if you can run this version of Grails you shouldn't have any problems.

You must also have a Slack channel where incoming webhooks are configured properly. For more details see https://api.slack.com/incoming-webhooks.  

## Installation

Once you have done cloning the project you will have to configure your own environment. To do so, create a copy of the `.env.template` file and rename it to `.env`.

```bash
cp .env.template .env
```

Open the copied `.env` file in your favorite editor and change the environment variable `SLACK_WEBHOOK_URL` to your channel incoming webhook URL.

 
```
SLACK_WEBHOOK_URL=https://hooks.slack.com/services/XXXXXXXXX/XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
```

Now you can run the project using Grails CLI.

```bash
grails run-app
```

## Testing

If you want to run the tests just use the Grails CLI.

```bash
grails test-app
```

## How to use?

You can send messages to your Slack channel making `POST` requests to the endpoint `/message`.

```
curl -X POST \
  http://localhost:8080/message \
  -H 'content-type: application/json' \
  -d '{
    "text": "Hello, World!"
}'
```

After each request you should see the message in your Slack channel.
