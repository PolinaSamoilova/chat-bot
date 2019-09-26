if [[ "$1" == "addrepo" ]]
then 
	git config --global user.email "evgeniy8a8p@gmail.com"
	git config --global user.name "PapaKarlo787"
    git remote add chatbot https://github.com/PolinaSamoilova/chat-bot
fi

if [[ "$1" == "pull" ]]
then
    git init
    git pull https://github.com/PolinaSamoilova/chat-bot
fi

git add .
git status

if [[ "$1" == "push" ]]
then 
    git commit -m "$2"
    git push -u chatbot master
fi

