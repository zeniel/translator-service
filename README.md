# translator-service
This service receives raw messages from message queue and translate these messages to known events with improved value in the platform, like: a message from gitlab(merge_request) can be translated to a payload with issue name, issue responsible, issue status, group channel in slack and so on.
