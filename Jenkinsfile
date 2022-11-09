peline { 
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
       
    }
}
