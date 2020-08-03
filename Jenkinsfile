pipeline {
    agent none

    def dockerPath = tool 'docker'
    env.PATH = "${dockerPath}/bin:${env.PATH}"
    stages {
//         stage('init') {
//           steps {
//            script{
//              def dockerPath = tool 'docker'
//              env.PATH = "${dockerPath}/bin:${env.PATH}"
//            }
//           }
//    }


        stage('Example') {
            agent { docker 'maven:3.6.3' }
            steps {
                echo "Running ${env.BUILD_NUMBER} on ${env.JENKINS_URL}"
                echo "Running $env.BUILD_NUMBER on $env.JENKINS_URL"
                echo "Running ${BUILD_NUMBER} on ${JENKINS_URL}"
                sh "mvn --version"
            }
        }
        stage('Build') {
            agent { docker 'maven:3.6.3' }
            steps {
                echo 'Building'
                sh "mvn --version"
                sh 'mvn -B -DskipTests clean package'
                sh 'docker --version'
            }
        }
        stage('Test') {
            agent { docker 'maven:3.6.3' }
            steps {
                echo 'Testing'
                sh "mvn --version"
                sh 'mvn test'
                sh 'docker --version'
            }
        }
        stage('Deploy') {
            agent { docker 'maven:3.6.3' }
            steps {
                echo 'Deploying'
                sh "mvn --version"
                sh 'mvn install '
                sh 'docker --version'
            }
        }
    }
    post {
        agent { docker 'maven:3.6.3' }
        always {
            //junit testResults: "**/target/sure-reports/*.xml"
            sh "mvn --version"
            echo "building is finish!"
            sh 'docker --version'
        }
    }
}
