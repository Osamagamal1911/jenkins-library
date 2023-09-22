pipeline {
    agent {
        label 'slave'
    }

    stages {
        stage('Install Nginx') {
            steps {
                script {
                    shared_library.installNginx()
                }
            }
        }
    }
}
