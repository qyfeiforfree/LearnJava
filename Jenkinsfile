pipeline {
   agent {
                docker {
                    label ‘docker’
                    image 'maven:3.6.3'
                }
            }
    stages {
        stage('build') {
            
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
