node() {
    checkout scm
    stage('Build') {
        sh 'cd project_vue/'
        sh 'sudo npm i -g npm'
        sh 'npm run dev'
    }
}
