package Utils;


import org.apache.commons.cli.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cli {

    public static final String OPT_STR_HELP = "h";
    public static final String OPT_STR_INPUTFILE = "i";
    public static final String OPT_STR_OUTPUTDIR = "o";
    public static final String OPT_STR_DISTTHRESHOLD = "e";
    public static final String OPT_STR_DENTHRESHOLD = "u";
    public static final String OPT_STR_TIMEINTERVAL = "T";
    public static final String OPT_STR_LIFETIME = "k";
    public static final String OPT_STR_NUMPART = "n";

    private static final Logger log = Logger.getLogger(Cli.class.getName());
    private String[] args = null;
    private Options options = new Options();
    private CommandLineParser parser = new BasicParser();
    private CommandLine cmd = null;

    public Cli(String[] args) {

        this.args = args;

        options.addOption(OPT_STR_HELP, false, "show help");
        options.addOption(OPT_STR_INPUTFILE, true, "input file");
        options.addOption(OPT_STR_OUTPUTDIR, true, "output directory");
        options.addOption(OPT_STR_DISTTHRESHOLD, true, "distance threshold" );
        options.addOption(OPT_STR_DENTHRESHOLD, true, "density threshold");
        options.addOption(OPT_STR_TIMEINTERVAL, true, "time interval of a trajectory slot");
        options.addOption(OPT_STR_LIFETIME, true, "life time");
        options.addOption(OPT_STR_NUMPART, true, "number of sub-partitions");
    }

    public CommandLine getCmd()
    {
        return cmd;
    }

    public void parse() {
        try
        {
            cmd = parser.parse(options, args);

            if(cmd.hasOption(OPT_STR_HELP))
                help();

        }
        catch (ParseException e) {
            log.log(Level.SEVERE, "Failed to parse command line properties", e);
            help();
        }
    }

    public void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("TCFinder", options);
        System.exit(0);
    }

}