#!/usr/bin/python
import os
import ConfigParser
def get_config_val(cfg,section,key):
  config=ConfigParser.ConfigParser();
  config.read(cfg)
  if section == "" or key == "":
      print "section or key empty"
      return None;
  if config.has_section(section) == True:
      if config.has_option(section, key) == True:
              print "val:",config.get(section, key,)
              return config.get(section, key,)
      else:
          print "key not exist"
          return None
  else:
          print "section not exist"
          return None

def place_config(cfg,group,key,value):
  config=ConfigParser.ConfigParser();
  if group == "" or key == "":
      return
  config.read(cfg)
  if config.has_section(group) == True:
      if config.has_option(group, key) == True:
          print "[update]"
          config.set(group, key, value)
          config.write(open(cfg, "w"))
      else:
          print "[add option]"
          config.set(group, key, value)
          config.write(open(cfg, "w"))
  else:
      print "[add section]"
      config.add_section(group)
      config.set(group, key, value)
      config.write(open(cfg, "w"))

if __name__ == "__main__":
    import sys
    cfg = sys.argv[1];
    group = sys.argv[2];
    key = sys.argv[3];
    val = sys.argv[4];
    place_config(cfg, group, key, val);
