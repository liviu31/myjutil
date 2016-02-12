package com.myjutil.patterns;

/**
 * This is used to emulate a runtime generated enum. This is based on multiton design pattern
 * https://en.wikipedia.org/wiki/Multiton_pattern
 *
 * From a string it will map to an object (Just a proxy over an string)
 *
 * This is helpful in situation you have a finite number of strings and you just want to configure
 * them without code change; E.g.: Group
 *
 * This situation this can absolve you a few bugs:
 *
 * doSomething(String label, Group group)
 * vs
 * doSomething(String label, Group group)
 *
 * In the second situation you can't confuse the order of the parameters while in the first
 * situation this can be easily achieve.
 *
 *
 * User: liviu
 * Date: 11/30/15
 * Time: 11:43 PM
 */
public class MultitonEnum {




}
