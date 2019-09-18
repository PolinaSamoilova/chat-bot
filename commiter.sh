if [[ "$1" == "addrepo" ]]
then 
    git remote add chatbot https://github.com/PolinaSamoilova/chat-bot
fi

if [[ "$1" == "pull" ]]
then 
    git pull https://github.com/PolinaSamoilova/chat-bot
fi

echo were:
git status
git add .
echo became:
git status

if [[ "$1" == "push" ]]
then 
    git commit -m "$2"
    git push -u chatbot master
fi
