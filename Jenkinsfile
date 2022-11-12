pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') { 
            steps { 
                sh 'mvn -version'
		sh 'mvn clean package' 
            }
        }
     stage ('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      }
    }

	stage('Sonar') {
            steps {
        	withSonarQubeEnv('sonarQubeServ') { 
        		sh "mvn sonar:sonar"
    		}
            }
        }
      
    }
}
