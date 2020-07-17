pipeline {
   agent none
    stages {
        stage('build') {
            agent any
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
