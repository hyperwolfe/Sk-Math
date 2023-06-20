package org.skriptsound.skriptaddon.elements;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.Variable;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.skriptsound.skriptaddon.Gamma;

import javax.annotation.Nullable;

public class ExpressionFactorials extends SimpleExpression<Number> {

    static {
        Skript.registerExpression(ExpressionFactorials.class, Number.class, ExpressionType.SIMPLE, "%number%!");
    }

    private Expression<?> number;
    @Override
    public Class<? extends Number> getReturnType() {
        return Number.class;
    }

    public static double factorial(double n) {
        return Gamma.gamma(n + 1);
    }
    @Override
    public boolean isSingle() {
        return true;
    }



    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {


        if(exprs[0] == null) {
            Skript.error("Argument 1 must be a valid variable");
            return false;
        }
        number = exprs[0];

        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "factorial";
    }

    @Override
    @Nullable
    protected Number[] get(Event event) {
        Number n;
        if(number instanceof Variable) {
            n = (Number) ((Variable) number).getSingle(event);
        } else {
            n = (Number) number.getSingle(event);
        }
        Bukkit.getLogger().info("Raw Num: " + n);
        if(n == null) return new Number[]{0};
        double nValue = n.doubleValue();
        Bukkit.getLogger().info("Number Value: " + nValue);
        return new Number[]{factorial(nValue)};

    }
}
