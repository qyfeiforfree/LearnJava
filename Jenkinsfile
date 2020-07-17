pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building'
                 sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
                sh 'mvn install '
            }
        }
    }
}
