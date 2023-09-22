def call() {
    pipeline {
        agent {
            label 'slave'
        }
        stages {
            stage('installing') {
                steps {
                    script {
                        // Use 'apt-get' for Ubuntu to install nginx
                        sh "sudo apt-get update"
                        sh "sudo apt-get install nginx -y"
                    }
                }
            }
            stage("starting server") {
                steps {
                    script {
                        // Start the nginx service using 'systemctl' on Ubuntu
                        sh "sudo systemctl start nginx"
                    }
                }
            }
            stage("Testing") {
                steps {
                    script {
                        // Test the server by making a curl request to localhost
                        sh "curl localhost"
                    }
                }
            }
        }
    }
}
