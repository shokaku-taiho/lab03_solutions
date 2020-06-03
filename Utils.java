public class Utils {
  
  public static String[] findAndReplace( String[] in, String[] what, String[] with ){
      String[] out = null;
      boolean valid = true;

      	if ( in == null || what == null || with == null ){
      	    valid=false;
      	}
        else {
            if (what.length!=with.length){
                valid=false;
            }
            for (int i=0; i<in.length; i++){
                if (in[i]==null){
                    valid=false;
                }
            }
            for (int i=0; i<what.length; i++){
                if (what[i]==null||with[i]==null){
                    valid=false;
                }
            }
      	}

      	if ( valid ) {
      	    out = new String[ in.length ];
      	    for ( int i=0; i<in.length; i++ ){
                out[i]=in[i];
      	    }
            for ( int i=0; i<in.length; i++){
                for ( int j=0; j<what.length; j++){
                    if (in[i].equals(what[j]) && in[i]==out[i]){
                        out[i]=with[j];
                    }
                }
            }
      	}
        return out;
    }
}
