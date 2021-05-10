node('maven') {
    env.M2_HOME = "${tool 'Maven3.5.4'}"
    env.JAVA_HOME = "${tool 'jdk1.8.0_172'}"
    env.SONARQUBESCANNER_HOME = "${tool 'SonarQubeScanner3.3.0'}"
    env.PATH = "${env.JAVA_HOME}/bin:${env.M2_HOME}/bin:${env.SONARQUBESCANNER_HOME}/bin:${env.PATH}"

    stage('Checkout') {
	    checkout scm
    }

    stage('Build & P3C Analysis') {
        withSonarQubeEnv('SonarQube7.6-9003') {
            sh 'mvn clean package sonar:sonar -Pp3c-quality-profile-jdk8'
        }
    }

    stage('Build & Default Analysis') {
        withSonarQubeEnv('SonarQube7.6') {
            sh 'mvn clean package sonar:sonar -Pdefault-quality-profile-jdk8'
        }
    }
}
