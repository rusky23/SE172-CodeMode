/* Requires the Docker Pipeline plugin */
node() {
    checkout scm
    stage('Build') {
        docker.image('node:6.3').inside {
            sh 'npm --version'
        }
    }
}
