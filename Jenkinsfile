pipeline {
     agent any
    stages {
         stage('Example'){
              steps{
                   echo "Running ${env.BUILD_NUMBER} on ${env.JENKINS_URL}"
                   echo "Running $env.BUILD_NUMBER on $env.JENKINS_URL"
                   echo "Running ${BUILD_NUMBER} on ${JENKINS_URL}"
              }
         }
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
     post{
          always{
          junit testResults: "**/target/sure-reports/*.xml"
          }
     }
}
