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