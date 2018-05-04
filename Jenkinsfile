node() {
    checkout scm
    stage('Build') {
        sh 'sudo npm i -g npm'
        sh 'npm install --prefix project_vue/'
        sh 'ansible-playbook ansible-stop-server.yaml'
        sh 'ansible-playbook ansible-start-server.yaml'
        echo 'Node packages are up to date and ansible has run project'
    }
}
