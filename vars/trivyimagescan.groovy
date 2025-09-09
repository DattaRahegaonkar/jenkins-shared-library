def call(String imageName, String reportName) {
  sh "trivy image ${imageName} --format table -o ${reportName} --exit-code 0 --severity HIGH,CRITICAL || true"
}
