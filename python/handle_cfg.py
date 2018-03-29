#!/usr/bin/python
def get_config_val(cfg,group,key):
  import ConfigParser
  config=ConfigParser.ConfigParser();
  config.read(cfg)
  print "has sections:", config.has_section(group)
  print "sections:",config.sections()
  print "has options:",config.has_option(group,key)
  print "options:",config.options(group)
  return config.get(group,key);
def place_config(cfg,group,key,value):
  import ConfigParser
  config=ConfigParser.ConfigParser();
  import os
  if os.path.isfile(cfg):
      config.read(cfg)
      if config.has_section(group) == True:
          if config.has_option(group, key) == True:
              print "[update]"
              config.set(group, key, value)
              config.write(open(cfg, "r+"))
          else:
              print "[add option]"
              config.set(group, key, value)
              config.write(open(cfg, "r+"))
      else:
          print "[add section]"
          config.add_section(group)
          config.set(group, key, value)
          config.write(open(cfg, "r+"))
  else:
        print "[new]"
        config.add_section(group);
        config.set(group, key, value)
        config.write(open(cfg, "w"));
if __name__ == "__main__":
    import sys
    cfg = sys.argv[1];
    group = sys.argv[2];
    key = sys.argv[3];
    val = sys.argv[4];
    place_config(cfg, group, key, val);

