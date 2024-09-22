pipeline {
    agent any

    stages {

        stage('Compile Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'MAVEN', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        bat "${mvnHome}\\bin\\mvn clean compile"
                    }
                }

            }
        }

        stage('Test Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'MAVEN', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        bat "${mvnHome}\\bin\\mvn test -Dtest=UsersRunner"
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
