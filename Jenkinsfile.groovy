pipeline {
    agent any

    stages {

        stage('Test Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'maven_3_9_9', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        bat "${mvnHome}\\bin\\mvn test -Dtest=PostsRunner"
                    }
                }
            }

        }

        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                        fileIncludePattern: "**/cucumber.json",
                        jsonReportDirectory: 'target'
            }
        }

    }

}
