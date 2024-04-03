import groovy.json.JsonSlurper

def pipelinesListFileName = "pipelines_list"
def projects = new JsonSlurper().parseText(new File("${WORKSPACE}",pipelinesListFileName).text)

for  (def folderPath: projects.keySet()) {
    if(folderPath != 'rbac-folders') {
        if(folderPath != 'default') {
            def _folderPath = ""
            for(String individualFolderName : folderPath.split("/")) {
                _folderPath += individualFolderName
                println "Creating folder: " + _folderPath
                folder(_folderPath) {
                    displayName(individualFolderName)
                }
                _folderPath += "/"
            }
        }

        projects.get(folderPath).each { job ->
            def jobName = '/'+job.name.trim()

        }
    }
}