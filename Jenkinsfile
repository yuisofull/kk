#!/usr/bin/env groovy
def gv
pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    }
    stages {
        stage('init'){
            gv = load "script.groovy"
        }
        stage('build jar') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo',usernameVariable: 'USER', passwordVariable: 'PWD')]) {
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh 'docker build -t yuisofull/demo:jma-1.0 .'
                        sh 'docker push yuisofull/demo:jma-1.0'
                    }
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    gv.deployApp()                }
            }
        }
    }
}
