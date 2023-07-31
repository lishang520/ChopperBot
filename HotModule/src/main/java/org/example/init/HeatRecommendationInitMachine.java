package org.example.init;

import org.example.constpool.PluginName;
import org.example.core.recommend.HeatRecommendation;
import org.example.log.ChopperLogFactory;
import org.example.log.LoggerType;

import java.util.List;

/**
 * @author Genius
 * @date 2023/07/29 14:48
 **/
public class HeatRecommendationInitMachine extends CommonInitMachine{

    public static HeatRecommendation heatRecommendation;

    public HeatRecommendationInitMachine() {
        super(  List.of(PluginName.HOT_CONFIG_PLUGIN,PluginName.HOT_GUARD_PLUGIN),
                ChopperLogFactory.getLogger(LoggerType.Hot),
                PluginName.HOT_RECOMMENDATION_PLUGIN
        );
    }

    @Override
    public boolean init() {

        try {
            heatRecommendation = new HeatRecommendation();
        }catch (Exception e){
            return fail();
        }

        return success();
    }

    @Override
    public void afterInit() {

        heatRecommendation.guardian();
    }
}