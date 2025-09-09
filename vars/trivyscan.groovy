def call(String fsname){
  sh "trivy fs . --format table -o ${fsname}"
}
