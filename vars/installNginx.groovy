def call() {
    pipeline {
        agent {
            label 'slave'
        }
        stages {
            stage('Install Nginx') {
                steps {
                    script {
                        sh 'apt-get update'
                        sh 'apt-get install -y nginx'
                    }
                }
            }
          
        post {
            always {
                script {
                    sh 'nginx -v'
                }
            }
        }
    }
}
