#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentials: 'docker-hub-repo',usernameVariable: USER, passwordVariable: PWD)]) {
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh 'docker build -t yuisofull/demo:jma-1.0'
                        sh 'docker push yuisofull/demo:jma-1.0'
                    }
                }
            }
        }i
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
