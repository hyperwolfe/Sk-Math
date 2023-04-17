# Sk-Cuts
Sk-cuts is a plugin for Minecraft servers that adds new functionality to the Skript plugin. It includes several new syntaxes that can be used to modify variables and compare objects.  

Installation
To use Sk-cuts, you'll need to have Skript installed on your Minecraft server. You can download Skript from the [offical github](https://github.com/SkriptLang/Skript/releases).  

Once Skript is installed, you can download Sk-cuts from the [GitHub repository](https://github.com/matthewbrumpton/Sk-Cuts/releases) and place it in the plugins/Skript/scripts/ folder on your server.  

Syntax
Sk-cuts includes the following new syntaxes:  

%number% += %number%: Add a value to a variable.  
%number% -= %number%: Subtract a value from a variable.  
%number% *= %number%: Multiply a variable by a value.   
%number% /= %number%: Divide a variable by a value.  
%number% ^= %number%: Raise a variable to a power.  
%object% == %object%: Set an object to another object.  
Examples  
Here are some examples of how you can use Sk-cuts syntaxes:  
<pre>
set {x} to 5
{y} += 3 # This adds 3 to the value of {y}
{z} *= 2 # This multiplies the value of {z} by 2

{list1} == {1, 2, 3}
{list2} == {4, 5, 6}

{list2} == {list1} # This sets list2 to be equal to list1
</pre>
