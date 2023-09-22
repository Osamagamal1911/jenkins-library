pipeline {
    agent {
        label 'slave'
    }

    stages {
        stage('Install Nginx') {
            steps {
                script {
                    mySharedLibrary.installNginx()
                }
            }
        }
    }
}
