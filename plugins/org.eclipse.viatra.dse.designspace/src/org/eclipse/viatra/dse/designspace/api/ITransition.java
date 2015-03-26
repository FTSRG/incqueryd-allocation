/*******************************************************************************
 * Copyright (c) 2010-2014, Miklos Foldenyi, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Miklos Foldenyi - initial API and implementation
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.designspace.api;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.statecode.IStateSerializer;

/**
 * <p>
 * Abstract representation of a model transition in the design space exploration process. See {@link IDesignSpace} for
 * explanation of the general concept.
 * </p>
 * 
 * <p>
 * A {@link ITransition transition} is a link between two {@link IState state}s pointing from
 * {@link ITransition#getFiredFrom() one} to the {@link ITransition#getResultsIn() other}.
 * </p>
 * 
 * <p>
 * While a {@link ITransition transition} can be un-fired and have a null value as it's result, it is always assigned to
 * a {@link IState state} from which it is fired.
 * </p>
 * 
 * 
 */
public interface ITransition {
    /**
     * Every {@link ITransition state} has a unique id with regards to the {@link IState state} they are linked to, that
     * was generated by a {@link IStateSerializer serializer}. An attempt to add a different {@link ITransition state}
     * to a given {@link IState state} with the same id will be ignored. See
     * {@link IDesignSpace#addState(ITransition, Object, java.util.Map)} and
     * {@link IStateSerializer#serializePatternMatch(IPatternMatch)} for more details.
     * 
     * @return the id of the {@link ITransition}.
     */
    Object getId();

    /**
     * <p>
     * The {@link IState state} which we will move to if this particular transition is fired in the state given by
     * {@link ITransition#getFiredFrom()}.
     * </p>
     * 
     * <p>
     * If this {@link ITransition transition} has never been fired before, then this method returns <b>null</b>.
     * </p>
     * 
     * @return The {@link IState} instance specified above, or null.
     */
    IState getResultsIn();

    /**
     * <p>
     * The {@link IState} which this {@link ITransition transition} is fired from.
     * </p>
     * 
     * <p>
     * As opposed to {@link ITransition#getResultsIn()} this method can not return null, as any {@link ITransition
     * transition} has a point of origin.
     * </p>
     * 
     * @return The {@link IState} instance specified above. Can not be null.
     */
    IState getFiredFrom();

    /**
     * Returns the {@link TransitionMetaData} of this {@link ITransition transition}, which contains data like the
     * corresponding {@link DSETransformationRule} and the costs of the activation
     * 
     * @return the {@link TransitionMetaData}
     */
    TransitionMetaData getTransitionMetaData();

    /**
     * Setter for the target of this {@link ITransition transition}
     * 
     * @param state
     *            the {@link IState} instance this {@link ITransition transition} points to
     */
    void setResultsIn(IState state);

    /**
     * 
     * @return True if the transition is already traversed or is being traversed.
     */
    boolean isAssignedToFire();

    /**
     * Called when the transition is assigned to fire by an exploration strategy.
     * 
     * @return True if successful. False if an other thread is already called this method.
     */
    boolean tryToLock();
}
