package equalityEquations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class VariableSet {
	Set<Character> variables;
	Set<VariableSet> dushmanSets;
	public VariableSet() {
		super();
		variables = new HashSet<>();
		dushmanSets = new HashSet<>();
	}
	
	void addVar(char x) {
		variables.add(x);
	}
	
	void addDushmanSet(VariableSet vs) {
		dushmanSets.add(vs);
	}
	
	static VariableSet union(VariableSet vs1, VariableSet vs2) {
		VariableSet union = new VariableSet();
		union.variables.addAll(vs1.variables);
		union.variables.addAll(vs2.variables);
		
		union.dushmanSets.addAll(vs1.dushmanSets);
		union.dushmanSets.addAll(vs2.dushmanSets);
		return union;
	}
	
	
}
public class Solution {

	public boolean equationsPossible(String[] equations) {
		char firstVar, secondVar;
		String operation;
		Map<Character, VariableSet> setWhereItBelongs = new HashMap<>();
		VariableSet vs1, vs2, r;
        for(String equation : equations) {
        	firstVar = equation.charAt(0);
        	secondVar = equation.charAt(3);
        	
        	operation = equation.substring(1, 3);
        	vs1 = setWhereItBelongs.get(firstVar);
    		vs2 = setWhereItBelongs.get(secondVar);
        	if(operation.equals("==")) {
        		// equality
        		
        		if(vs1 == null && vs2 == null) {
        			// both variables are unknown
        			vs1 = new VariableSet();
        			vs1.addVar(firstVar);
        			vs1.addVar(secondVar);
        			setWhereItBelongs.put(firstVar, vs1);
        			setWhereItBelongs.put(secondVar, vs1);
        		}
        		else if(vs1 == null && vs2 != null) {
        			// the firstVar is unknown but second is known
        			vs2.addVar(firstVar);
        			setWhereItBelongs.put(firstVar, vs2);
        		}
        		else if(vs1 != null && vs2 == null) {
        			// first is known but second is unknown
        			vs1.addVar(secondVar);
        			setWhereItBelongs.put(secondVar, vs1);
        		}
        		else {
        			// both variables are known
        			if(vs1 == vs2) {
            			// nothing to do
            		}
        			else {
        				// vs1 != vs2
        				// both variables were known
        				// and were unequal
        				if(vs1.dushmanSets.contains(vs2) || vs2.dushmanSets.contains(vs1))
        					return false;
        				else {
        					// union of vs1 and vs2
        					VariableSet union = VariableSet.union(vs1, vs2);
        					// change the mapping everywhere
        					Iterator<Entry<Character, VariableSet>> it = setWhereItBelongs.entrySet().iterator();
        					while(it.hasNext()) {
        						Entry<Character, VariableSet> entry = it.next();
        						r = entry.getValue();
        						if(r == vs1 || r == vs2) {
        							setWhereItBelongs.put(entry.getKey(), union);
        						}
        					}
        				}
        					
        			}
        		}        		
        		
        	}
        	
        	else {
        		// operation == "!="
        		if(firstVar == secondVar) {
        			return false;
        		}
        		if(vs1 == null && vs2 == null) {
        			// both the variables are unknown
        			// and should be in different dushman sets
        			vs1 = new VariableSet();
        			vs1.addVar(firstVar);
        			vs2 = new VariableSet();
        			vs2.addVar(secondVar);
        			vs1.addDushmanSet(vs2);
        			vs2.addDushmanSet(vs1);
        			setWhereItBelongs.put(firstVar, vs1);
        			setWhereItBelongs.put(secondVar, vs2);
        		}
        		else if(vs1 == null && vs2 != null) {
        			// the firstVar is unknown but second is known
        			vs1 = new VariableSet();
        			vs1.addVar(firstVar);
        			setWhereItBelongs.put(firstVar, vs1);
        			vs1.addDushmanSet(vs2);
        			vs2.addDushmanSet(vs1);
        			
        		}
        		else if(vs1 != null && vs2 == null) {
        			vs2 = new VariableSet();
        			vs2.addVar(secondVar);
        			setWhereItBelongs.put(secondVar, vs2);
        			vs2.addDushmanSet(vs1);
        			vs1.addDushmanSet(vs2);
        		}
        		else {
        			// both variables were known
        			if(vs1 == vs2) {
        				// if they are in the same set, return false
        				return false;
        			}
        			// different sets
        			vs2.addDushmanSet(vs1);
        			vs1.addDushmanSet(vs2);
        		}
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] equations = {"a!=a"};
		System.out.println(s.equationsPossible(equations));

	}

}
