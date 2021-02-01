# Deux méthodes ont été utilisées pour decoriser ce rest api

### 1) Créer le jar avec maven et puis deckoriser le jar
### La première métode utilise le fihier Dockerfile.
### Veuillez l'ouvrire et le lire
### Pour créer l'image
docker build -t springboot-restapi:0.1 .
### Pour démarrer le container:
docker run -p 8090:8080 springboot-restapi:0.1
### Tester l'application en récupérant le seule utilisateur crée mootez elhosni
http://localhost:8090/api/users


### 2) Créer le projet /src et pom.xml et puis dockoriser le build maven, le packaging
docker build -t springboot-restapi-imagemaven:0.1 . -f Dockerfilepom
### Pour démarrer le container:
docker run -p 8090:8080 springboot-restapi-imagemaven:0.1
### Tester l'application en récupérant le seule utilisateur crée mootez elhosni
http://localhost:8090/api/users


### 3) pour faire l push de ces images dans github il faut exécuter ces commandes ci-dessou
docker tag local-image:tagname new-repo:tagname
docker push new-repo:tagname
### Pour exemple on a utilisé le compte elhosni sur dockerhub pour créer un repo elhosni/### devops et on a fait pusher le build image de restapi 1 dans ce repo les étapes suivies ### sont:
### 3-a le build de l'image:
docker build -t springboot-restapi:0.1 .
### 3-b le tag de l'image:
docker tag springboot-restapi:0.1 elhosni/devops:0.1
### 3-c le push de l'image:
docker push elhosni/devops:0.1
### 3-d le pull de projet pour vérifier:
docker pull elhosni/devops:0.1
### 3-e l'affichage de l'image 
docker images
### 3-f le run de l'image et la construction de conteneur
docker run -p 8090:8080 elhosni/devops:0.1