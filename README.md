Framework de loggin a creer. Utiliser les logger, regle de priorite (debug, info, error)

Logger logger = LoggerFactory.getLogger(MaClasse.class)
logger.debug("test log")
logger.info("test log")
logger.error("test log")

Spe :

Configurer le framework en java (properties java)

Liberte sur le format de config de la declaration

Fournir les cibles (fichier, fichier rotatif=>serveur de log si on ecrit dans un fichier avec une limite de taille impose (taille max des fichier de 1mega par exemple) puis si taille max on passe au fichier suivant), generer un fichier texte!

Cree un design qui permet de rajouter une cible et un formateur de log sans devoir toucher le code, implementtion de l'ocp.

Il faut le creer ! Ne pas utiliser les framework existant, s'en inspirer pour creer le framework de log sur mesure.

Utiliser des design patern!

Date de rendu: 27 fevrier a 12h.

Contact par mail possible. Si reponse du prof, poster la reponse par mail a la promo pour systeme de FAQ avec prof en copie.
