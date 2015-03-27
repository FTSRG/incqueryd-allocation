/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.recipes.test;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.recipes.RecipeProcessor;
import hu.bme.mit.incqueryd.recipes.TypeInfo;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

public class RecipeProcessorTest {
	
	@Test
	public void extractTypeName() {
		 RecipesFactory.eINSTANCE.eClass();
		 final BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		 recipe.setTypeName("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Route_routeDefinition");
		 final TypeInfo extractType = RecipeProcessor.extractType(recipe);
		 assertEquals("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl", extractType.getOntologyIri());
		 assertEquals("Route_routeDefinition", extractType.getTypeNameSuffix());
	}
	
}
