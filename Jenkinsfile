
node('master') {
    try {
       notifyStarted()
    
       stage('Clean') {
          deleteDir()
          echo 'Excluir conteudo'
          sh 'ls -la'
          echo 'Conteudo excluido'
       }

       stage('Fetch') {
          checkout scm
       }

//       stage('APIDocs') {
//            sh 'apidoc -i src/ -o /srv/www/docs.idealinvest.dev/public_html/neo-Proposal'
//            sh 'apidoc -i src/ -o /srv/www/wiki.intranet.idealinvest.com.br/public_html/mediawiki/api/neo-Proposal'
//       }

//       stage('Code Standards') {
//          sh 'phpcs --standard=PSR2 src/'
//       }
    
//       stage('Copy/Paste') {
//          sh 'phpcpd src/'
//       }

//       stage('Composer') {
//          sh 'composer install --prefer-dist --ignore-platform-reqs'
//       }        
    
//       stage('Unit Tests') {
//            sh './bin/phpunit --coverage-html results/ --coverage-clover results/clover.xml --whitelist=src/ --log-junit results/phpunit/phpunit.xml -c phpunit.xml'
//          sh 'phpunit --coverage-html results/ --coverage-clover results/clover.xml --whitelist=src/ --log-junit results/phpunit/phpunit.xml -c phpunit.xml'
//       }

//       stage('Analysis') {
//         sh 'php phing-latest.phar'
//         step([
//            $class: 'CloverPublisher',
//            cloverReportDir: 'results/',
//            cloverReportFileName: 'clover.xml',
//            healthyTarget: [methodCoverage: 70, conditionalCoverage: 70, statementCoverage: 70],
//            unhealthyTarget: [methodCoverage: 60, conditionalCoverage: 50, statementCoverage: 50],
//            failingTarget: [methodCoverage: 50, conditionalCoverage: 30, statementCoverage: 30]
//        ])
//       }

       stage('Release') {
          sh """git config --global user.email \"ahrocha@gmail.com\" """
          sh """git config --global user.name \"Andrey Rocha\" """
          sh 'git@github.com:ahrocha/feijoadaweek-site-spring.git'
          sh 'git fetch'
//          sh 'git checkout phpunit.xml'
//          sh 'git checkout phpunit.xml.dist'
          sh 'git checkout develop'
          sh 'git pull origin develop'
//          sh 'rm .env.dist'
//          sh 'rm .env.test'
//          sh 'rm config/packages/test/routing.yaml'
//          sh 'rm symfony.lock'
//          sh 'rm composer.lock'
          sh 'git checkout .env'
//          sh 'git checkout phpunit.xml.dist'
          sh 'git checkout master'
          sh """echo ${env.BUILD_NUMBER} > build.txt"""
          sh 'git add .'
          sh """git commit -m \"build ${env.BUILD_NUMBER}\" """
          sh 'git merge develop'
          sh 'git push origin master'
          sh """git tag -fa 1.0.1-${env.BUILD_NUMBER} -m \"- build jenkins\" """
          sh """git push origin 1.0.1-${env.BUILD_NUMBER} """
       }

//       stage('SonarQube') {
//            sh '/opt/sonar-scanner/bin/sonar-scanner'
//       }

       notifySuccessful()

    } catch (e) {    
       currentBuild.result = "FAILED"
       notifyFailed()
       throw e
    }

}

def notifyStarted() {
    emailext ( 
        subject: "STARTED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]", 
        body: "STARTED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]: Check console output at ${env.BUILD_URL} ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        recipientProviders: [[$class: 'DevelopersRecipientProvider']]
     )
 }

def notifyFailed() {
    emailext (
        subject: "FAILED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        body: "FAILED: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]: Check console output at ${env.BUILD_URL} ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}

def notifySuccessful() {
    emailext (
        subject: "SUCCESSFUL: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        body: "SUCCESSFUL: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]: Check console output at ${env.BUILD_URL} ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
        recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}
