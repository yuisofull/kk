def buildApp(){
	echo "Building the application..."
	sh 'mvn package'
}

def deployApp(){
	echo "Deploying the application..."
}

return this
