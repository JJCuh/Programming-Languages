module Athlete
    def getName() #returns name
    end
    def setName(name) #changes name
    end
    def getAge() #returns age
    end
    def setAge(age) #changes age
    end
    def getContractLength() #returns contract length
    end
    def resign(years) #changes player's contract length
    end
    def getSalary() #returns salary
    end
    def setSalary(salary) #changes salary
    end
    def getInjury() #returns injury status
    end
    def setInjury(isInjured) #changes player's injury status
    end
end

class FootballPlayer
    include Athlete

    private
    #Zero-arg constructor of Football Player
    def initialize()
        puts("What is this player's name?")
        @name = gets.chomp
        puts("What is " + @name + "'s position?")
        @position = gets.chomp
        @number = (rand() * 100).round
        @age = (rand() * 20).round + 20
        @contractLength = (rand() * 5).round + 1
        @salary = (rand() * 9500000.0 + 500000).round(2)
        @overall = (rand() * 40).round + 60
        @isInjured = false
    end

    #Multi-arg constructor of Football Player
    def initialize2(name, position, number, age, salary, overall, isInjured, contractLength)
        @name = name
        @position = position
        @number = number
        @age = age
        @contractLength = contractLength
        @salary = salary
        @overall = overall
        @isInjured = isInjured
    end

    public
    #returns player's name
    def getName()
        return @name
    end

    #changes player's name
    def setName(name)
        @name = name
    end

    #returns player's position
    def getPosition()
        return @position
    end

    #changes player's position
    def setPosition(position)
        @position = position
    end

    #returns player's number
    def getNumber()
        return @number
    end

    #changes player's number
    def setNumber(number)
        @number = number
    end

    #returns player's age
    def getAge()
        return @age
    end

    #changes player's age
    def setAge(age)
        @age = age
    end

    #returns player's contract length
    def getContractLength()
        return @contractLength
    end

    #changes player's contract length
    def resign(years)
        @contractLength += years
    end

    #returns player's salary
    def getSalary()
        return @salary
    end

    #changes player's salary
    def setSalary(salary)
        @salary = salary.round(2)
    end

    #returns player's overall
    def getOverall()
        return @overall
    end

    #changes player's overall
    def setOverall(overall)
        @overall = overall
    end

    #returns player's injury status
    def getInjury()
        return @isInjured
    end

    #changes player's injury status
    def setInjury(isInjured)
        @isInjured = isInjured
    end

    #to_s prints all attributes of player
    def to_s()
        output = @name + ": \n" + "Position: " + @position + "\nNumber: " + @number.to_s + "\nAge: " + @age.to_s + "\nContract Length: " + @contractLength.to_s + "\nSalary: $" + @salary.to_s + "\nOverall: " + @overall.to_s + "\nInjured: " + @isInjured.to_s + "\n"
        return output
    end

end #end of class FootballPlayer

class SportsTeam
    private
    #Constructor
    def initialize()
        puts("What is the team name?")
        @teamName = gets.chomp
        puts("What is the team color?")
        @teamColor = gets.chomp
        puts("What is the location of the team?")
        @location = gets.chomp
    end

    public
    #Methods:
    #Changes the team's name
    def setTeamName(name)
        @teamName = name
    end

    #Returns the team name
    def getTeamName()
        return @teamName
    end

    #Returns the team color
    def getTeamColor()
        return @teamColor
    end

    #Assigns a team color
    def setTeamColor(teamColor)
        @teamColor = teamColor
    end

    #Gets the city of the team
    def getLocation()
        return @location
    end

    #Changes the city of the team
    def move(city)
        @location = city
    end

end #end of SportsTeam

class FootballTeam < SportsTeam
    private
    #Constructor
    def initialize()
        super()
        @starters = Array.new(10)
        for i in 0..9
            @starters[i] = FootballPlayer.new
        end
        @subs = Array.new
        for i in 0..4
            @subs[i] = FootballPlayer.new
        end
        @numPlayers = 15
        @wins = 0
        @losses = 0
        @ties = 0
        @inPlayoffs = false
        @gamesPlayed = 0
        @seasonsPlayed = 0
        @champsWon = 0
    end

    public
    #Methods
    #Adds a rand()om player to the team
    def addPlayer()
        if(@numPlayers < 25 && calcTeamSalary() < 200000000)
            @subs << FootballPlayer.new
            @numPlayers+=1
            puts @subs[@subs.size-1].getName + " was added to the roster."
        else
            puts "Sorry. Either your roster is full or you are at the salary cap limit."
        end
    end

    #Adds a user-creaated player to the team
    def addPlayer2(footballPlayer)
        if(@numPlayers < 25 && calcTeamSalary < 200000000)
            @subs << footballPlayer
            @numPlayers+=1
            puts footballPlayer.getName + " was added to the roster."
        else
            puts "Sorry. Either your roster is full or you are at the salary cap limit."
        end
    end

    #Drops the team's last sub player
    def dropPlayer()
        if(@numPlayers > 10)
            puts("You will be dropping " + @subs[@subs.size-1].getName + " who has an overall of " + @subs[@subs.size-1].getOverall().to_s + ". Are you sure you would like continue? ")
            answer = gets.chomp
            if(answer == "yes") 
                @numPlayers-=1               
                puts @subs.pop.getName + " was released from the team."              
                #print(to_s)
            elsif(answer == "no")
                puts @subs[@subs.size - 1].getName + " was not removed from the squad. "
            else
                puts("That was not an option. Please try again.")
                dropPlayer
            end
        else
            puts "Sorry, but you currently don't have enough players."
        end
    end

    #Drops the player of choice
    def dropPlayer2(footballPlayer)
        @subs - [footballPlayer]
        @numPlayers-=1
        puts footballPlayer.getName + " was released from the team."
    end

    #Counts the number of players on the roster
    def getNumPlayers()
        return @numPlayers
    end

    #Gets the team salary
    def calcTeamSalary()
        teamSalary = 0
        @starters.each do |s|
            teamSalary += s.getSalary
        end
        @subs.each do |t|
            teamSalary += t.getSalary
        end
        return teamSalary.round(2)
    end

    #Puts the highest overall players in the starting team
    #Sorts the team from greatest overall players to lowest overall players (Selection)
    def updateTeam()
        @starters.each do |s|
            @subs.push(s)
        end
        for i in 0..@starters.size-1
            max = @subs[0]
            @subs.each do |t|
                if(t.getOverall > max.getOverall)
                    max = t
                end
            end
            @subs.delete(max)
            @starters[i] = max
        end
        for i in 0..@subs.size-2
            max = @subs[i]
            k = i
            for j in i+1..@subs.size-1
                if(@subs[j].getOverall > max.getOverall)
                    max = @subs[j]
                    k = j
                end
            end
            temp = @subs[i]
            @subs[i] = max
            @subs[k] = temp
        end      
    end

    #Calculates and returns the team's average overall
    def calcTeamOverall()
        teamOverall = 0
        @starters.each do |s|
            teamOverall += s.getOverall
        end
        teamOverall /= @starters.size
        return teamOverall
    end

    #Sets the amount of team's season wins
    def setWins(wins)
        @wins = wins
    end

    #Increases the team's season wins by 1
    def increaseWins()
        @wins+=1
    end

    #Sets the amount of team's season losses
    def setLosses(losses)
        @losses = losses
    end

    #Increases the team's season losses by 1
    def increaseLosses()
        @losses+=1
    end

    #Sets the amount of team's season losses
    def setTies(ties)
        @ties = ties
    end

    #Increases the team's season ties by 1
    def increaseTies()
        @ties+=1
    end

    #Gets the wins, losses, and ties the team had in the season
    def getRecord()
        return "Record: " + @wins.to_s + "-" + @losses.to_s + "-" + @ties.to_s + "\n"
    end

    #Returns whether the team is currently in the playoffs or not
    def getInPlayoffs()
        return @inPlayoffs
    end

    #Changes the team's playoff condition
    def setInPlayoffs()
        @inPlayoffs = true
    end

    #Sets the amount of games played
    def setGamesPlayed(games)
        @gamesPlayed = games
    end

    #Gets the amount of games played
    def getGamesPlayed()
        return @gamesPlayed
    end

    #Plays a game in a season
    def playGame()
        if(!@inPlayoffs)
            oppOvr = (rand * 21).round + 70
        else
            oppOvr = (rand * 16).round + 80
        end
        puts("Your team overall is " + calcTeamOverall.to_s)
        puts("The opponent's team overall is " + oppOvr.to_s)
        overDiff = calcTeamOverall - oppOvr
        maxScore1 = 50 + overDiff
        maxScore2 = 50 - overDiff
        score1 = (rand * maxScore1).round
        score2 = (rand * maxScore2).round
        @gamesPlayed+=1
        if(@inPlayoffs)
            while(score1 == score2)
                score1 = (rand * maxScore1).round
                score2 = (rand * maxScore2).round
            end
        end
        puts("Your team scored " + score1.to_s + " points.")
        puts("The opponent team scored " + score2.to_s + " points.")
        if(score1 > score2)
            puts("Your team won the game! \n")
            increaseWins()
            if(@gamesPlayed == 19)
                puts("Congratulations! You won the superbowl!!! :) Time to party! :D")
                increaseChampsWon
                seasonReset
            elsif(@gamesPlayed == 18)
                puts("Congratulations! You made the superbowl!!! Best of Luck!")
            elsif(@inPlayoffs)
                puts("You have moved on to the next round :)")
            end
        elsif(score1 < score2)
            puts("The opponent won the game. :( \n")
            increaseLosses
            if(@inPlayoffs)
                puts("You have been knocked out of the playoffs :(")
                seasonReset
            end
        elsif(score1 == score2)
            puts("Both teams tied. \n")
            increaseTies
        end
        if(@gamesPlayed == 16)
            puts("Your final season record is " + getRecord)
            if(@wins >= 9)
                setInPlayoffs
                puts("Congratulations! You have made the playoffs!")
            else
                seasonReset
                puts("Sorry, you didn't make the playoffs :( Maybe next year!")
            end
        end
    end

    #Resets to a new season
    def seasonReset()
        @wins = 0
        @losses = 0
        @ties = 0
        @inPlayoffs = false
        @gamesPlayed = 0
        increaseSeasonsPlayed
        @starters.each do |s|
            s.resign(-1)
        end
        @subs.each do |s|
            s.resign(-1)
        end
        returnLegacy
    end

    #Gets the amount of seasons the team played
    def getSeasonsPlayed()
        return @seasonsPlayed
    end

    #Adds 1 season to the amount of seasons the team played
    def increaseSeasonsPlayed()
        @seasonsPlayed+=1
    end

    #Gets the amouont of championships the team won
    def getChampsWon()
        return @champsWon
    end

    #Adds 1 to the amount of champsionships the team won
    def increaseChampsWon()
        @champsWon+=1
    end

    #Returns the team's overall legacy
    def returnLegacy()
        return "Seasons played: " + @seasonsPlayed.to_s + "\nChampionships won: " + @champsWon.to_s + "\n"
    end

    #Prints every player on the team
    def to_s()
        @starters.each do |s|
            output += s.to_s
        end
        @subs.each do |t|
            output += t.to_s
        end
        return output
    end

end #end of FootballTeam class

#Seasons
    #Introduces player to the game
    puts("Hi. Welcome to Seasons mode. Before we begin, what is your name?")
    name = gets.chomp
    puts("Welcome to the game, " + name)
    help = "Options: add, drop, update, play, color, move, record, salary, roster, legacy, quit, help"
    puts(help)
    puts("If you ever forget the options, type in 'help' for a reminder")
    puts("Your team will now be assembled")
    footballTeam = FootballTeam.new
    while (footballTeam.getSeasonsPlayed < 10)
        puts("What would you like to do?")
        decision = gets.chomp
        if(decision == "add")
            footballTeam.addPlayer
        elsif(decision == "drop")
            footballTeam.dropPlayer
        elsif(decision == "update")
            footballTeam.updateTeam
            puts "Roster updated"
        elsif(decision == "play")
            footballTeam.playGame
        elsif(decision == "color")
            puts("What do you want to change the team color to?")
            choice = gets.chomp
            footballTeam.setTeamColor(choice)
            puts "Team color changed to " + footballTeam.getTeamColor
        elsif(decision == "move")
            puts("Where do you want to move to")
            choice = gets.chomp
            footballTeam.move(choice)
            puts "You have moved to " + footballTeam.getLocation
        elsif(decision == "record")
            puts(footballTeam.getRecord)
        elsif(decision == "salary")
            puts("Team Salary: $" + footballTeam.calcTeamSalary().to_s)
        elsif(decision == "roster")
            puts "Number of players on the roster: " + footballTeam.getNumPlayers().to_s
            puts "Team overall is: " + footballTeam.calcTeamOverall().to_s
        elsif(decision == "legacy")
            puts(footballTeam.returnLegacy)
        elsif(decision == "quit")
            puts("Are you sure you want to quit?")
            choice = gets.chomp
            if(choice == "yes")
                break
            end
        else
            puts(help)
        end
    end #end of first 10 seasons
    puts("Thanks for playing! :)")
