/*
 * generated by Xtext
 */
package org.eclipse.incquery.patternlanguage.mondix.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.incquery.patternlanguage.mondix.ui.internal.MondixPatternLanguageActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MondixPatternLanguageExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MondixPatternLanguageActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MondixPatternLanguageActivator.getInstance().getInjector(MondixPatternLanguageActivator.ORG_ECLIPSE_INCQUERY_PATTERNLANGUAGE_MONDIX_MONDIXPATTERNLANGUAGE);
	}
	
}
