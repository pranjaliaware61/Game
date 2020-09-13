package com.loylogic.pointspay.gameoflife;

import com.loylogic.pointspay.gameoflife.rules.Rule;
import com.loylogic.pointspay.gameoflife.rules.RuleImpl;

/**
 * 
 * @author Hitesh.Dhingra@loylogic.com
 *
 */
public class DefaultGameStratedgy extends AbstractGameStratedgy {

	public DefaultGameStratedgy()
	{
		setRules(new Rule[]{new RuleImpl()});
	}
	
}
