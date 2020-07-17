pipeline {
    agent none
    stages {
        stage('build') {
            agent {
                docker {
                    image 'maven:3.6.3'
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
