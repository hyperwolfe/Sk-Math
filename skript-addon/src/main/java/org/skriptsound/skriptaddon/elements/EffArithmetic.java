package org.skriptsound.skriptaddon.elements;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer;
import ch.njol.skript.lang.*;
import ch.njol.skript.variables.Variables;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.skriptsound.skriptaddon.Skript_addon;

import javax.annotation.Nullable;
import java.nio.DoubleBuffer;

public class EffArithmetic extends Effect {

    static {
        Skript.registerEffect(EffArithmetic.class, "%number% += %number%",
                "%number% -= %number%",
                "%number% *= %number%",
                "%number% /= %number%",
                "%number% ^= %number%");
    }

    private Expression<Variable> changed;
    private Expression<Double> changer;

    private String changeMode;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        if (expressions[0] == null || expressions[1] == null) {
            Skript.error("Argument 1 and Argument 2 must be valid");
            return false;
        }
        if (!(expressions[0] instanceof Variable)) {
            Skript.error("Argument 1 must be a valid variable");
            return false;
        }

        this.changed = (Expression<Variable>) expressions[0];
        this.changer = (Expression<Double>) expressions[1];

        switch (matchedPattern) {
            case 0:
                changeMode = "+=";
                break;
            case 1:
                changeMode = "-=";
                break;
            case 2:
                changeMode = "*=";
                break;
            case 3:
                changeMode = "/=";
                break;
            case 4:
                changeMode = "^=";
                break;
            default:
                return false;
        }

        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return changed.toString() + " " + changeMode + " " + changer.toString();
    }

    @Override
    protected void execute(Event e) {
        Object changedObject = changed.getSingle(e);
        Object changerObject = changer.getSingle(e);


        double changedValue = ((Number) changedObject).doubleValue();
        double changerValue = ((Number) changerObject).doubleValue();

        switch (changeMode) {
            case "+=":

                changed.change(e, new Object[]{changedValue + changerValue}, Changer.ChangeMode.SET);
                break;
            case "-=":
                changed.change(e, new Object[]{changedValue - changerValue}, Changer.ChangeMode.SET);
                break;
            case "*=":
                changed.change(e, new Object[]{changedValue * changerValue}, Changer.ChangeMode.SET);
                break;
            case "/=":
                changed.change(e, new Object[]{changedValue / changerValue}, Changer.ChangeMode.SET);
                break;
            case "^=":
                changed.change(e, new Object[]{Math.pow(changedValue, changerValue)}, Changer.ChangeMode.SET);
                break;
        }
    }
}