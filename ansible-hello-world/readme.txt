Ansible-deployed "Hello World" Apache Webserver

Brings up a web server on the local machine at port 81 to be accessed publically.
The web server displays "Hello World!"
Ports must be properly forwarded for public access to work correctly.
The host and port can be changed in 'start_server.yaml'

Prerequisites:
OS: CentOS 7 (control machine)
Ansible 2.4.2.0

Run Steps:
1. 'cd' to the project folder.
2. Start the server with 'ansible-playbook start_server.yaml'.
  a. The server port can be changed by changing the 'server_port' var.
  b. The host can be changed by changing the 'host' noted at the top of the playbooks.
3. Stop the server with 'ansible-playbook stop_server.yaml'.
