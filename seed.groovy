pipelineJob("greetingJob") {
  
  parameters {
         stringParam('name', "", 'name of the person')
        }
  definition {
           cps {
             script('''
                 pipeline {
                    agent any
                    stages {
                        stage('Greet1') {
                            steps {
                                echo "Hello!! ${name}"
                            }
                         }
                      }
                   }
              '''.stripIndent())
       sandbox()
          }
      }
  }