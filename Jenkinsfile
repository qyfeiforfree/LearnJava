pipeline {
    script {
        def dockerPath = tool 'docker'
        env.PATH = "${dockerPath}/bin:${env.PATH}"
    }
    agent { docker 'maven:3.6  .3' }
    stages {

/*
         stage('init') {
           steps {
            script{
              def dockerPath = tool 'docker'
              env.PATH = "${dockerPath}/bin:${env.PATH}"
            }
           }
    }
*/

        stage('Example') {
            steps {
                echo "Running ${env.BUILD_NUMBER} on ${env.JENKINS_URL}"
                echo "Running $env.BUILD_NUMBER on $env.JENKINS_URL"
                echo "Running ${BUILD_NUMBER} on ${JENKINS_URL}"
            }
        }
        stage('Build') {
            steps {
                echo 'Building'
                sh 'mvn -B -DskipTests clean package'
                sh 'docker --version'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                sh 'mvn test'
                sh 'docker --version'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
                sh 'mvn install '
                sh 'docker --version'
            }
        }
    }
    post {
        always {
            //junit testResults: "**/target/sure-reports/*.xml"
            echo "building is finish!"
            sh 'docker --version'
        }
    }
}
