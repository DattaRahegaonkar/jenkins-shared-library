def call(String imageName, String tagName){
  sh "docker build -t ${imageName}:${tagName} ."  
}
