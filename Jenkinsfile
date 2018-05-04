node() {
    checkout scm
    stage('Build') {
        sh 'sudo npm i -g npm'
        sh 'npm install --prefix project_vue/'
        sh 'npm run dev --prefix project_vue/'
    }
}
